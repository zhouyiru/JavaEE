package cn.it.utils;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Configuration {
	private Configuration(){}
	public static final String PATH ="e:\\testdir\\lucene35";
	public static final Version VERSION =Version.LUCENE_30;
	public static final Analyzer ANALYZER = new StandardAnalyzer(VERSION);
	private static  Directory directory;
	static{
		try {
			directory = FSDirectory.open(new File(PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Directory getDirectory(){
		return directory;
	}

}
