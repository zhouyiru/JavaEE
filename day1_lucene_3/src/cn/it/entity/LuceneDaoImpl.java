package cn.it.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import cn.it.utils.BeanUtil;
import cn.it.utils.Configuration;

public class LuceneDaoImpl {
	
/*	1.构建索引库
	Directory directory = FSDirectory.open(new File("索引库目录"));
2.指定分词器，版本一般指定为最高
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
3.创建文档对象，并添加相关字段值
			Document doc = new Document();
			doc.add(new Field("goodsId",goods.getGoodsId().toString(),Store.YES,Index.NOT_ANALYZED));
4.创建增删改索引库的操作对象，添加文档并提交
			IndexWriter indexWriter = new IndexWriter(directory, analyzer, MaxFieldLength.LIMITED);
			indexWriter.addDocument(doc);
			indexWriter.commit();
5.关闭操作对象*/
	
	/**
	 * @Title:  保存商品到文档库
	 * @auth:chufeng
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param goods
	 * @return void 返回类型
	*/ 
	public void saveGoods(Goods goods){
		IndexWriter indexWriter = null;
		try {
			
			Document document = BeanUtil.beanToDocument(goods);
			//Store.YES表示数据在存到文档库，
			//Index.ANALYZED表示按规则进行分词;Index.NO_ANALYZED表示把整体的值作为关键字；Index.NO表示不作为索引
			/*document.add(new Field("goodsId",goods.getGoodsId().toString(),Store.YES,Index.ANALYZED));
			document.add(new Field("goodsName",goods.getGoodsName(),Store.YES,Index.ANALYZED));
			document.add(new Field("goodsPrice",goods.getGoodsPrice().toString(),Store.YES,Index.ANALYZED));
			document.add(new Field("goodsRemark",goods.getGoodsRemark(),Store.YES,Index.ANALYZED));*/
			
			//通过操作类进行数据的存放
			indexWriter  = new IndexWriter(Configuration.getDirectory(),Configuration.ANALYZER,MaxFieldLength.LIMITED);
			indexWriter.addDocument(document);
			indexWriter.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(indexWriter!=null){
				try {
					indexWriter.close();
				} catch (CorruptIndexException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
/*	1.打开索引库
	directory = FSDirectory.open(new File("索引库目录"));
	2。创建查询分词器，版本号与写入文档的查询分词器一样
				Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
	3。创建查询解析器，参数为版本号，查询字段名，分词器
				QueryParser parser = new QueryParser(Version.LUCENE_30, "goodsName", analyzer);
	4。构建查询信息对象
				Query query = parser.parse(keyWord);
	5。构建查询工具
				searcher = new IndexSearcher(directory);
	6。通过查询工具执行查询。参数1，查询信息对象；参数2。返回记录数；TopDocs包括总记录数、文档编号等
				TopDocs topDocx=searcher.search(query, 20);
	7。根据文档编号遍历真正的文档
				ScoreDoc sd[] = topDocx.scoreDocs;
				for(ScoreDoc scoreDoc:sd){
					。。。
					Document doc = searcher.doc(scoreDoc.doc);
	8。转为java对象									goods.setGoodsId(Integer.parseInt(doc.get("goodsId")));
	   lists.add(goods);
	9.关闭查询操作对象*/
	/**
	 * @Title: 根据商品名称查询商品（列表）
	 * @auth:chufeng
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param keyWord
	 * @param @return
	 * @return List<Goods> 返回类型
	*/ 
	public List<Goods> selectGoods(String keyWord){
		List<Goods> list= new ArrayList<Goods>();
		IndexSearcher indexSearcher = null;
		try {
			//Directory directory = FSDirectory.open(new File("e:\\testdir\\lucene35"));
			//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);
			QueryParser parser = new QueryParser(Version.LUCENE_30,"goodsName",Configuration.ANALYZER);
			Query query = parser.parse(keyWord);
			indexSearcher = new IndexSearcher(Configuration.getDirectory());
			TopDocs topDocs = indexSearcher.search(query, 20);
			System.out.println("总记录数："+topDocs.totalHits);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for(ScoreDoc s:scoreDocs){
				System.out.println("文档编号："+s.doc);
				//通过文档编号取出文档
				Document document = indexSearcher.doc(s.doc);
				//把文档对象的值给bean对象
				Goods goods = (Goods) BeanUtil.DocumentToBean(Goods.class, document);
				/*new Goods();
				goods.setGoodsId(Integer.parseInt(document.get("goodsId")));
				goods.setGoodsName(document.get("goodsName"));
				goods.setGoodsPrice(Double.parseDouble(document.get("goodsPrice")));
				goods.setGoodsRemark(document.get("goodsRemark"));*/
				list.add(goods);				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(indexSearcher!=null){
				try {
					indexSearcher.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

	/**
	 * @Title:  修改文档内容
	 * @auth:chufeng
	 * @Description:修改文档内容
	 * @param @param goods
	 * @return void 返回类型
	*/ 
	public void updateGoods(Goods goods){
		IndexWriter indexWriter = null;
		try {
			
			Document document = BeanUtil.beanToDocument(goods);		
			//通过操作类进行数据的存放
			indexWriter  = new IndexWriter(Configuration.getDirectory(),Configuration.ANALYZER,MaxFieldLength.LIMITED);
			/*
			 *根据字段的值进行修改数据内容；原则，先删除再添加
			 *如果字段值不存在，将新增一条记录（文档）
			 *如果字段值唯一，那就相当 于根据主键修改数据；
			 *如果字段值对应有多条数据记录（文档），则其它记录（文档）将被逻辑删除后，再添加一记录（文档）
			 */
			//参数term的第一个参数指定字段，第二个参数指定字段对应值，匹配到对应的信息会把相关信息删除，再把document信息添加
			indexWriter.updateDocument(new Term("goodsId", goods.getGoodsId().toString()), document);
			indexWriter.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(indexWriter!=null){
				try {
					indexWriter.close();
				} catch (CorruptIndexException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void deleteGoods(Goods goods){
		IndexWriter indexWriter = null;
		try {
			
			Document document = BeanUtil.beanToDocument(goods);		
			//通过操作类进行数据的存放
			indexWriter  = new IndexWriter(Configuration.getDirectory(),Configuration.ANALYZER,MaxFieldLength.LIMITED);
			
			// 参数一：指定处理的字段，参数二：指定关键字(词），如果对应多条记录，多条记录也被删除
			indexWriter.deleteDocuments(new Term("goodsId",goods.getGoodsId().toString()));
			indexWriter.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(indexWriter!=null){
				try {
					indexWriter.close();
				} catch (CorruptIndexException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}


}
