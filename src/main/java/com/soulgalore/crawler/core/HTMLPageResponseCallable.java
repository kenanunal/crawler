/******************************************************
 * Web crawler
 * 
 *
 * Copyright (C) 2012 by Peter Hedenskog (http://peterhedenskog.com)
 *
 ******************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License. You may obtain a copy of the License at
 * 
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is 
 * distributed  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   
 * See the License for the specific language governing permissions and limitations under the License.
 *
 *******************************************************
 */
package com.soulgalore.crawler.core;

import java.util.concurrent.Callable;



/**
 * A callable that fetch a HTTP response code and return response to the caller.
 *
 */
public class HTMLPageResponseCallable implements Callable<HTMLPageResponse> {

	private final HTMLPageResponseFetcher fetcher;
	private final PageURL url;
	private final boolean fetchPage;


	/**
	 * Create a new callable.
	 * 
	 * @param theUrl
	 *            the url to call.
	 * @param theFetcher
	 *            the fetcher to use
	 * @param fetchTheBody
	 *            if true, the response body is fetched, else not.
	 */
	public HTMLPageResponseCallable(PageURL theUrl, HTMLPageResponseFetcher theFetcher, boolean fetchTheBody) {

		url = theUrl;
		fetcher = theFetcher;
		fetchPage = fetchTheBody; 

	}

	/**
	 * Fetch the actual response.
	 * 
	 * @return the response
	 * @throws InterruptedException
	 *             if it takes longer time than the configured max time to fetch
	 *             the response
	 */
	public HTMLPageResponse call() throws InterruptedException {
		return fetcher.get(url, fetchPage);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " url:" + url;
	}
}
