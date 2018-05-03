# Styla Hybris Plugin

This plugin connects your Hybris Store with [Styla](http://www.styla.com/) magazine. The first diagram on [this page](https://styladocs.atlassian.net/wiki/spaces/CO/pages/9961481/Technical+Integration) should provide you an overview of what the plugin does and how it exchanges data with Styla. 

The plugin relies on hybris’ Service Layer Architecture and needs version 5.0 or higher.

## Installation and Configuration

Please consult the [documentation](https://github.com/styladev/pluginHybris/tree/master/documentation) folder for information on how to install and configure the plugin. 

### New Layout Engine

If you start using Styla in 2018 or want to switch afterwards, you will use Styla's New Layout Engine. 

In order to do that, please make sure that you do the change introduced in v 2.2 of the documentation in the table on page 11:

**was in 2.1:**
`styla.scripts.baseurl  = //cdn.styla.com/scripts/clients`
`styla.styles.baseurl   = //cdn.styla.com/styles/clients`

**is in 2.2:**
`styla.scripts.baseurl  = //client-scripts.styla.com/scripts/clients`
`styla.styles.baseurl   = //client-scripts.styla.com/styles/clients`

Only the settings below will make using the NLE possible. You set them in project.properties or in your local.properties.

## Setup Process

The process of setting up your Content Hub(s) usually goes as follows:

1. Install and configure the plugin on your stage using Content Hub ID(s) shared by Styla
2. Share the stage URL, credentials with Styla
4. Styla integrates product data from endpoints provided by the plugin, test your stage Content Hub and asks additional questions, if needed
5. Install and configure the plugin on production, without linking to the Content Hub(s) there and, again, share the URL with Styla
6. Make sure your content is ready to go live
7. Styla conducts final User Acceptance Tests before the go-live
8. Go-live (you link to the Content Hub embedded on your production)
