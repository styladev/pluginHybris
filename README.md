# Styla Hybris Plugin

This plugin connects your Hybris Store with [Styla](http://www.styla.com/) magazine. The first diagram on [this page](https://styladocs.atlassian.net/wiki/spaces/CO/pages/9961481/Technical+Integration) should provide you an overview of what the plugin does and how it exchanges data with Styla. 

The plugin relies on hybris’ Service Layer Architecture and needs version 5.0 or higher.

## Installation and Configuration

Please consult the [documentation](https://github.com/styladev/pluginHybris/tree/master/documentation) folder for information on how to install and configure the plugin. 

## Setup Process

The process of setting up your Content Hub(s) usually goes as follows:

1. Install and configure the plugin on your stage using Content Hub ID(s) shared by Styla
2. Share the stage URL, credentials with Styla
4. Styla integrates product data from endpoints provided by the plugin, test your stage Content Hub and asks additional questions, if needed
5. Install and configure the plugin on production, without linking to the Content Hub(s) there and, again, share the URL with Styla
6. Make sure your content is ready to go live
7. Styla conducts final User Acceptance Tests before the go-live
8. Go-live (you link to the Content Hub embedded on your production)
