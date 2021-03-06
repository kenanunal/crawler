package com.soulgalore.crawler.core;

/**
 * Configuration for a crawl.
 * 
 */
public final class CrawlerConfiguration {

	/**
	 * The default crawl level if no is supplied.
	 */
	public static final int DEFAULT_CRAWL_LEVEL = 1;
	
	/**
	 * The default value if url:s shourl be verified to be ok or not.
	 */
	public static final boolean DEFAULT_SHOULD_VERIFY_URLS = true;
	
	private int maxLevels = DEFAULT_CRAWL_LEVEL;
	private String notOnPath = "";
	private String onlyOnPath = "";

	private String startUrl;

	private boolean verifyUrls =  DEFAULT_SHOULD_VERIFY_URLS;

	private CrawlerConfiguration() {

	}

	public int getMaxLevels() {
		return maxLevels;
	}

	public String getNotOnPath() {
		return notOnPath;
	}

	public String getOnlyOnPath() {
		return onlyOnPath;
	}

	public String getStartUrl() {
		return startUrl;
	}

	public boolean isVerifyUrls() {
		return verifyUrls;
	}

	private CrawlerConfiguration copy() {
		final CrawlerConfiguration conf = new CrawlerConfiguration();
		conf.setMaxLevels(getMaxLevels());
		conf.setNotOnPath(getNotOnPath());
		conf.setOnlyOnPath(getOnlyOnPath());
		conf.setStartUrl(getStartUrl());
		conf.setVerifyUrls(isVerifyUrls());
		return conf;

	}

	private void setMaxLevels(int maxLevels) {
		this.maxLevels = maxLevels;
	}

	private void setNotOnPath(String notOnPath) {
		this.notOnPath = notOnPath;
	}

	private void setOnlyOnPath(String onlyOnPath) {
		this.onlyOnPath = onlyOnPath;
	}

	private void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	private void setVerifyUrls(boolean verifyUrls) {
		this.verifyUrls = verifyUrls;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxLevels;
		result = prime * result
				+ ((notOnPath == null) ? 0 : notOnPath.hashCode());
		result = prime * result
				+ ((onlyOnPath == null) ? 0 : onlyOnPath.hashCode());
		result = prime * result
				+ ((startUrl == null) ? 0 : startUrl.hashCode());
		result = prime * result + (verifyUrls ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrawlerConfiguration other = (CrawlerConfiguration) obj;
		if (maxLevels != other.maxLevels)
			return false;
		if (notOnPath == null) {
			if (other.notOnPath != null)
				return false;
		} else if (!notOnPath.equals(other.notOnPath))
			return false;
		if (onlyOnPath == null) {
			if (other.onlyOnPath != null)
				return false;
		} else if (!onlyOnPath.equals(other.onlyOnPath))
			return false;
		if (startUrl == null) {
			if (other.startUrl != null)
				return false;
		} else if (!startUrl.equals(other.startUrl))
			return false;
		if (verifyUrls != other.verifyUrls)
			return false;
		return true;
	}



	public static class Builder {
		private final CrawlerConfiguration configuration = new CrawlerConfiguration();

		public Builder() {
		}

		public CrawlerConfiguration build() {
			return configuration.copy();
		}

		public Builder setMaxLevels(int maxLevels) {
			configuration.setMaxLevels(maxLevels);
			return this;
		}

		public Builder setNotOnPath(String notOnPath) {
			configuration.setNotOnPath(notOnPath);
			return this;
		}

		public Builder setOnlyOnPath(String onlyOnPath) {
			configuration.setOnlyOnPath(onlyOnPath);
			return this;
		}

		public Builder setStartUrl(String startUrl) {
			configuration.setStartUrl(startUrl);
			return this;
		}

		public Builder setVerifyUrls(boolean verifyUrls) {
			configuration.setVerifyUrls(verifyUrls);
			return this;
		}
	}
	public static Builder builder() {
		return new Builder();
	}
	
	
}
