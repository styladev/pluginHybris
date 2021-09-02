/**
 *
 */
package com.styla.service.impl;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commercefacades.product.PriceDataFactory;
import de.hybris.platform.commercefacades.product.data.PriceDataType;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.product.PriceService;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.product.VariantsService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.stock.StockService;
import de.hybris.platform.stock.exception.StockLevelNotFoundException;
import de.hybris.platform.util.PriceValue;
import de.hybris.platform.variants.model.VariantAttributeDescriptorModel;
import de.hybris.platform.variants.model.VariantProductModel;
import de.hybris.platform.variants.model.VariantTypeModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.styla.json.Attribute;
import com.styla.json.Option;
import com.styla.json.Product;
import com.styla.json.ProductVariant;
import com.styla.service.StylaProductProvider;


/**
 *
 */
public class DefaultStylaProductProvider implements StylaProductProvider
{
	@Autowired
	private ProductService productService;

	@Autowired
	private StockService stockService;

	@Autowired
	private PriceService priceService;

	@Autowired
	private PriceDataFactory priceDataFactory;

	@Autowired
	private VariantsService variantsService;

	private final static Logger LOG = Logger.getLogger(DefaultStylaCategoryProvider.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see com.styla.service.ProductProvider#getProduct(java.lang.String)
	 */
	@Override
	public Product getProduct(final String id)
	{
		try
		{
			final ProductModel productModel = productService.getProductForCode(id);
			final Product stylaProduct = new Product();
			final PriceValue priceValue = getPriceValue(productModel);

			stylaProduct.setId(productModel.getCode());
			stylaProduct.setName(productModel.getName());
			stylaProduct.setDescription(productModel.getDescription());
			stylaProduct.setSaleable(Boolean.valueOf(isSalable(productModel)));

			if (priceValue != null)
			{
				final double price = priceValue.getValue();
				final String currencyIso = priceValue.getCurrencyIso();

				stylaProduct.setPrice(String.valueOf(price));
				stylaProduct.setPriceTemplate(
						priceDataFactory.create(PriceDataType.BUY, BigDecimal.valueOf(price), currencyIso).getFormattedValue());
			}

			if (!productModel.getVariants().isEmpty())
			{
				final List<Attribute> attributes = new ArrayList<Attribute>();
				final Map<String, Collection<Object>> assignedVariantAttributes = variantsService
						.getAssignedVariantAttributes(productModel);

				final VariantTypeModel variantType = productModel.getVariantType();
				for (final VariantAttributeDescriptorModel variantAttribute : variantType.getVariantAttributes())
				{
					final List<Option> options = new ArrayList();
					final Attribute attribute = new Attribute();
					attribute.setId(variantAttribute.getQualifier());
					attribute.setLabel(variantAttribute.getName());

					for (final Object variantAttributeValue : assignedVariantAttributes.get(variantAttribute.getQualifier()))
					{
						if (variantAttributeValue == null)
						{
							continue;
						}

						final List<ProductVariant> productVariants = new ArrayList();
						final Option option = new Option();
						option.setId(variantAttribute.getQualifier() + "_" + variantAttributeValue.toString());
						option.setLabel(variantAttributeValue.toString());
						for (final VariantProductModel variantProduct : variantsService.getVariantProductForAttributeValues(
								productModel, Collections.singletonMap(variantAttribute.getQualifier(), variantAttributeValue)))
						{
							productVariants.add(getProductVariant(variantProduct.getCode()));
						}
						option.setProducts(productVariants);
						options.add(option);
					}

					if (!options.isEmpty())
					{
						attribute.setOptions(options);
						attributes.add(attribute);
					}
				}

				stylaProduct.setAttributes(attributes);
			}

			if (!productModel.getSupercategories().isEmpty())
			{
				final List<String> categories = new ArrayList<String>();
				stylaProduct.setCategories(categories);

				for (final CategoryModel category : productModel.getSupercategories())
				{
					categories.add(category.getCode());
				}
			}

			return stylaProduct;
		}
		catch (final AmbiguousIdentifierException a)
		{
			LOG.warn("Failed to lookup unique product for code [" + id + "]. " + a.getMessage());
		}
		catch (final UnknownIdentifierException u)
		{
			LOG.warn("Failed to lookup product for code [" + id + "]. " + u.getMessage());
		}
		catch (final IllegalArgumentException i)
		{
			LOG.warn("Failed to lookup product. Invalid code [" + id + "]. " + i.getMessage());
		}

		return null;
	}

	private ProductVariant getProductVariant(final String id)
	{
		try
		{
			final ProductModel productModel = productService.getProductForCode(id);
			if (productModel instanceof VariantProductModel)
			{
				final ProductVariant stylaProduct = new ProductVariant();
				final List<PriceInformation> prices = priceService.getPriceInformationsForProduct(productModel);
				final PriceValue priceValue = prices.isEmpty() ? null : prices.get(0).getPriceValue();
				stylaProduct.setId(productModel.getCode());
				stylaProduct.setSaleable(Boolean.valueOf(isSalable(productModel)));
				if (priceValue != null)
				{
					final double price = priceValue.getValue();
					stylaProduct.setPrice(String.valueOf(price));
				}

				return stylaProduct;
			}
		}
		catch (

		final AmbiguousIdentifierException a)

		{
			LOG.warn("Failed to lookup unique product for code [" + id + "]. " + a.getMessage());
		}
		catch (

		final UnknownIdentifierException u)

		{
			LOG.warn("Failed to lookup product for code [" + id + "]. " + u.getMessage());
		}
		catch (

		final IllegalArgumentException i)

		{
			LOG.warn("Failed to lookup product. Invalid code [" + id + "]. " + i.getMessage());
		}

		return null;
	}

	private PriceValue getPriceValue(final ProductModel productModel)
	{
		List<PriceInformation> prices = priceService.getPriceInformationsForProduct(productModel);

		// fallback to get any price
		if (prices.isEmpty() && !productModel.getVariants().isEmpty())
		{
			for (final VariantProductModel variant : productModel.getVariants())
			{
				prices = priceService.getPriceInformationsForProduct(variant);
				if (!prices.isEmpty())
				{
					break;
				}
			}
		}

		if (!prices.isEmpty())
		{
			return prices.get(0).getPriceValue();
		}

		return null;
	}

	private boolean isSalable(final ProductModel product)
	{
		try
		{
			return stockService.getTotalStockLevelAmount(product) > 0;
		}
		catch (final StockLevelNotFoundException s)
		{
			//
		}
		return false;
	}
}
