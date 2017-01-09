

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 50 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ){
	      // Get the file location where it would be stored.
	      filePath = getServletContext().getInitParameter("file-upload"); 
	   }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			

			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (!isMultipartContent) {
				return;
			}

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> fields = upload.parseRequest(request);
				
				
				
			      // Process the uploaded file items
				Iterator<FileItem> it = fields.iterator(); 
				
				
				
				if (!it.hasNext()) {
					out.println("No fields found");
					return;
				}
				
				while (it.hasNext()) {
					out.println("<tr>");
					FileItem fileItem = it.next();
					boolean isFormField = fileItem.isFormField();
					if (isFormField) {
						
						
						
					} else {
						try
						{ String s=fileItem.getName();
						String str=s.substring(0, s.indexOf("."));
						
							
						File file = File.createTempFile(str,".xls",new File("/home/mtech/Saved"));
					file.renameTo(new File("/home/mtech/Saved/input.xls"));
						File f=new File("/home/mtech/Saved/input.xls");
					fileItem.write(file);
						
						 if (f.exists()) f.delete();
						   file.renameTo(f);
						
						}
						catch(Exception e)
						{
							System.out.println("new file error"+e);
						}
						

					}
					
				}
				try{		 
					//System.out.println("Hello");
					ExcelReader er=new ExcelReader();
					er.main1();
						//System.out.println("Hello");
					response.sendRedirect("find.jsp");
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
				//String str=s.substring(0, s.indexOf("."));
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		
			
			
	}

}
