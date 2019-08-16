package com.documaster.rms.noark.ws.client;

import org.apache.http.client.fluent.Request;

public enum HttpMethod {

	GET {
		@Override
		public Request getRequest(String url) {

			return Request.Get(url);
		}
	},

	POST {
		@Override
		public Request getRequest(String url) {

			return Request.Post(url);
		}
	},

	PUT {
		@Override
		public Request getRequest(String url) {

			return Request.Put(url);
		}
	},

	DELETE {
		@Override
		public Request getRequest(String url) {

			return Request.Delete(url);
		}
	};

	public abstract Request getRequest(String url);
}
