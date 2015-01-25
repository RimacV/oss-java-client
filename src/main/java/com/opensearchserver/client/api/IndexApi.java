/**
 * Copyright 2015 OpenSearchServer Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensearchserver.client.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;

import com.opensearchserver.client.JsonClientAbstract;
import com.opensearchserver.utils.HttpUtils;
import com.opensearchserver.utils.LinkUtils;

public class IndexApi extends AbstractApi<JsonClientAbstract> {

	public IndexApi(JsonClientAbstract client) {
		super(client);
	}

	/**
	 * Create a new index
	 * 
	 * @param indexName
	 *            The name of the index
	 * @param templateName
	 *            The template
	 * @param msTimeOut
	 * @throws ClientProtocolException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void create(String indexName, String templateName)
			throws ClientProtocolException, UnsupportedEncodingException,
			IOException, URISyntaxException {
		URIBuilder uriBuilder = client.getBaseUrl("index/",
				LinkUtils.UTF8_URL_Encode(indexName), "/template/",
				LinkUtils.UTF8_URL_Encode(templateName));
		Request request = Request.Post(uriBuilder.build());
		HttpResponse response = client.execute(request, null, null);
		HttpUtils.checkStatusCodes(response.getStatusLine(), 200);
	}

	/**
	 * Check if the index exists.
	 * 
	 * @param indexName
	 *            The name of the index.
	 * @return true if the index exists, false if not.
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	/**
	 * 
	 * @param indexName
	 * @param msTimeOut
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 */
	public boolean exists(String indexName) throws URISyntaxException,
			IOException {
		URIBuilder uriBuilder = client.getBaseUrl("index/",
				LinkUtils.UTF8_URL_Encode(indexName));
		Request request = Request.Get(uriBuilder.build());
		HttpResponse response = client.execute(request, null, null);
		switch (HttpUtils.checkStatusCodes(response.getStatusLine(), 200, 404)) {
		case 200:
			return true;
		case 404:
			return false;
		}
		return false;
	}

	/**
	 * Delete index
	 * 
	 * @param indexName
	 *            The name of the index
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void delete(String indexName) throws IOException, URISyntaxException {
		URIBuilder uriBuilder = client.getBaseUrl("index/",
				LinkUtils.UTF8_URL_Encode(indexName));
		Request request = Request.Delete(uriBuilder.build());
		HttpResponse response = client.execute(request, null, null);
		HttpUtils.checkStatusCodes(response.getStatusLine(), 200);
	}
}
