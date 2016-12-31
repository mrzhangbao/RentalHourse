package com.jiaxin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class UploadFileServlet extends HttpServlet {

	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
	        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	        //�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
	        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
	        File file = new File(tempPath);
	        if(!file.exists()&&!file.isDirectory()){
	            System.out.println("Ŀ¼���ļ������ڣ�");
	            file.mkdir();
	        }
	        //��Ϣ��ʾ
	        String message = "";
	        try {
	            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
	            //1������һ��DiskFileItemFactory����
	            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	            //���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
	            diskFileItemFactory.setSizeThreshold(1024*100);
	            //�����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
	            diskFileItemFactory.setRepository(file);
	            //2������һ���ļ��ϴ�������
	            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
	            //����ϴ��ļ�������������
	            fileUpload.setHeaderEncoding("UTF-8");
	            //�����ļ��ϴ�����
	            fileUpload.setProgressListener(new ProgressListener(){
	                public void update(long pBytesRead, long pContentLength, int arg2) {
	                    System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���" + pBytesRead);
	                }
	            });
	            //3���ж��ύ�����������Ƿ����ϴ���������
	            if(!fileUpload.isMultipartContent(request)){
	                //���մ�ͳ��ʽ��ȡ����
	                return;
	            }
	            //�����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
	            fileUpload.setFileSizeMax(1024*1024);
	            //�����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
	            fileUpload.setSizeMax(1024*1024*10);
	            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
	            List<FileItem> list = fileUpload.parseRequest(request);
	            for (FileItem item : list) {
	                //���fileitem�з�װ������ͨ�����������
	                if(item.isFormField()){
	                    String name = item.getFieldName();
	                    //�����ͨ����������ݵ�������������
	                    String value = item.getString("UTF-8");
	                    String value1 = new String(name.getBytes("iso8859-1"),"UTF-8");
	                    System.out.println(name+"  "+value);
	                    System.out.println(name+"  "+value1);
	                }else{
	                    //���fileitem�з�װ�����ϴ��ļ����õ��ϴ����ļ����ƣ�
	                    String fileName = item.getName();
	                    System.out.println(fileName);
	                    if(fileName==null||fileName.trim().equals("")){
	                        continue;
	                    }
	                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
	                    //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
	                    fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
	                    //�õ��ϴ��ļ�����չ��
	                    String fileExtName = fileName.substring(fileName.lastIndexOf(".")+1);
	                    if("zip".equals(fileExtName)||"rar".equals(fileExtName)||"tar".equals(fileExtName)||"jar".equals(fileExtName)){
	                        request.setAttribute("message", "�ϴ��ļ������Ͳ����ϣ�����");
	                        request.getRequestDispatcher("/message.jsp").forward(request, response);
	                        return;
	                    }
	                    //�����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
	                    System.out.println("�ϴ��ļ�����չ��Ϊ:"+fileExtName);
	                    //��ȡitem�е��ϴ��ļ���������
	                    InputStream is = item.getInputStream();
	                    //�õ��ļ����������
	                    fileName = mkFileName(fileName);
	                    //�õ��ļ������·��
	                    String savePathStr = mkFilePath(savePath, fileName);
	                    System.out.println("����·��Ϊ:"+savePathStr);
	                    //����һ���ļ������
	                    FileOutputStream fos = new FileOutputStream(savePathStr+File.separator+fileName);
	                    //����һ��������
	                    byte buffer[] = new byte[1024];
	                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
	                    int length = 0;
	                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
	                    while((length = is.read(buffer))>0){
	                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
	                        fos.write(buffer, 0, length);
	                    }
	                    //�ر�������
	                    is.close();
	                    //�ر������
	                    fos.close();
	                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
	                    item.delete();
	                    message = "�ļ��ϴ��ɹ�";
	                }
	            }
	        } catch (FileUploadBase.FileSizeLimitExceededException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "�����ļ��������ֵ������");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	            return;
	        }catch (FileUploadBase.SizeLimitExceededException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	            return;
	        }catch (FileUploadException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            message = "�ļ��ϴ�ʧ��";
	        }
	        request.setAttribute("message",message);
	        request.getRequestDispatcher("/message.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    //�����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
	    public String mkFileName(String fileName){
	        return UUID.randomUUID().toString()+"_"+fileName;
	    }
	    public String mkFilePath(String savePath,String fileName){
	        //�õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
	        int hashcode = fileName.hashCode();
	        int dir1 = hashcode&0xf;
	        int dir2 = (hashcode&0xf0)>>4;
	        //�����µı���Ŀ¼
	        String dir = savePath + "\\" + dir1 + "\\" + dir2;
	        //File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
	        File file = new File(dir);
	        if(!file.exists()){
	            file.mkdirs();
	        }
	        return dir;
	    }

}
