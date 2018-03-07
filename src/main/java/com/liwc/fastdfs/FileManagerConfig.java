package com.liwc.fastdfs;

import java.io.Serializable;

public interface FileManagerConfig extends Serializable {

	String FILE_DEFAULT_AUTHOR = "liwc";

	String PROTOCOL = "http://";

	String SEPARATOR = "/";

	String TRACKER_NGNIX_ADDR = "47.104.20.231";

	String TRACKER_NGNIX_PORT = "";

	String CLIENT_CONFIG_FILE = "fdfs_client.conf";

//	String CLIENT_CONFIG_FILE = "fastdfs-client.properties";



}
