/**
 * 
 */
package com.gclouddemo.ecommerce.catalog.common;

import java.util.List;

import com.gclouddemo.ecommerce.catalog.common.bean.CatalogItem;

/**
 * A somewhat-abstract interface to the catalog store. Intended to be implemented
 * by Cloud SQL and Cloud Datastore implementation classes at least.
 */
public interface EcomCatalogConnection {
	boolean open() throws Exception;
	void close();
	List<CatalogItem> listItems(String category, String subCategory) throws Exception;
	List<CatalogItem> searchItems(String searchString) throws Exception;
	CatalogItem getSku(String sku) throws Exception;
	boolean insertItem(CatalogItem catalogItem) throws Exception;
}
