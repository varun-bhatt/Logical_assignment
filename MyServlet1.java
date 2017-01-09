import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String source1=request.getParameter("from");
		String dest1=request.getParameter("to");
		//System.out.print(source1+" "+dest1);
			List<Getter> gt = new ArrayList<Getter>();
			List<Getter> gt1 = new ArrayList<Getter>();
			 PreparedStatement pstm = null;
	      //      PreparedStatement pstm1= null;
		 /* List<String> object1 = new ArrayList<String>();
	        List<String> object2 = new ArrayList<String>();
	        List<String> object3 = new ArrayList<String>();*/
	    try
	    {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/My_data?autoReconnect=true&useSSL=false","root","root");
	           

	            String query="SELECT * FROM Routes";
	            pstm =  con.prepareStatement(query);
	           
	            ResultSet rs = pstm.executeQuery();
	           
	          //  ResultSet tmp = pstm.executeQuery();
	       	        
	        if(rs!=null)
	        {
	            while(rs.next())
	            {	Getter g = new Getter();
	            //    String sou=rs.getString("source");
	           //     if((sou.equals(source1)))
	          //      {    
	                   /* object1.add(rs.getString("source"));
	                    object1.add(rs.getString("dest"));
	                    object1.add(rs.getString("Courier_company"));
	                    object1.add(rs.getString("cost"));
	                    object1.add(rs.getString("time")); */
	                	
	                	g.setSource(rs.getString("source"));
	                	g.setDest(rs.getString("dest"));
	                	g.setCc(rs.getString("Courier_company"));
	                	g.setCost(rs.getInt("cost"));
	                	g.setTime(rs.getInt("time"));
	                	gt.add(g);
	            //		System.out.println(g.getSource()+""+g.getDest()+""+g.getCc()+""+g.getCost()+""+g.getTime());

	                }
	          //  }
	        }
	       System.out.println("whole db");
	      /*  for(Getter s:gt)
	        {
        		System.out.println(s.getSource()+""+s.getDest()+""+s.getCc()+""+s.getCost()+""+s.getTime());
	        }*/
	   /*     pstm1 =  con.prepareStatement(query);
	        ResultSet rs1=pstm1.executeQuery();
	        	*/
	    /*    	if(rs1!=null)
	        	{
	        		while(rs1.next())
	        		{	Getter g1 = new Getter();

	        			String des=rs1.getString("dest");
	        			if((des.equals(dest1)))
	        			{    
	        				
		                	g1.setSource(rs1.getString("source"));
		                	g1.setDest(rs1.getString("dest"));
		                	g1.setCc(rs1.getString("Courier_company"));
		                	g1.setCost(rs1.getInt("cost"));
		                	g1.setTime(rs1.getInt("time"));
		                	gt1.add(g1);
	        			}
	        		}
	        	}
	        	
	        	for(Getter s1:gt1)
	        	{
	        		System.out.println(s1.getSource()+""+s1.getDest()+""+s1.getCc()+""+s1.getCost()+""+s1.getTime());
	        	}*/
	        List<Getter> all_source=new ArrayList<Getter>();
	        for(Getter all_s:gt)
	        {
	        	if(all_s.getSource().equals(source1))
	        	{
	        		Getter obj=new Getter();
	        		obj.setSource(all_s.getSource());
	        		obj.setDest(all_s.getDest());
	        		obj.setCc(all_s.getCc());
	        		obj.setCost(all_s.getCost());
	        		obj.setTime(all_s.getTime());
	        		all_source.add(obj);
	        	}
	        }
	        System.out.println("all source");
	        for(Getter s1:all_source)
        	{
        		System.out.println(s1.getSource()+""+s1.getDest()+""+s1.getCc()+""+s1.getCost()+""+s1.getTime());
        	} 
	        List<Getter> all_dest=new ArrayList<Getter>();
	        for(Getter all_d:gt)
	        {
	        	if(all_d.getDest().equals(dest1))
	        	{
	        		Getter obj=new Getter();
	        		obj.setSource(all_d.getSource());
	        		obj.setDest(all_d.getDest());
	        		obj.setCc(all_d.getCc());
	        		obj.setCost(all_d.getCost());
	        		obj.setTime(all_d.getTime());
	        		all_dest.add(obj);
	        	}
	        }
	        
	        for(Getter s1:all_dest)
        	{
        		System.out.println(s1.getSource()+""+s1.getDest()+""+s1.getCc()+""+s1.getCost()+""+s1.getTime());
        	}
	       
	        List<Optimum> sort1=new ArrayList<Optimum>(); 
	        for(Getter one:all_source)
	        {
	        	if(one.getDest().equals(dest1))
	        	{
        			//System.out.println(one.getSource() +"->"+ one.getCc()+"->"+one.getDest()+" "+"cost="+one.getCost()+"->"+one.getTime() );
        			Optimum o=new Optimum();
	        		String str=one.getSource() +"->"+ one.getCc()+"->"+one.getDest()+"time="+one.getTime();
	        		
	        		o.setS(str);
	        		o.setCost(one.getCost());
	        		sort1.add(o);
        			
	        	}
	        	for(Getter two: all_dest)
	        	{
	        		
	        		if(one.getDest().equals(two.getSource()))
	        		{
	        			int total=one.getCost()+two.getCost();
	        			int time=one.getTime()+two.getTime();
	        			//System.out.println(one.getSource() +"->"+ one.getCc()+"->"+one.getDest()+"->"+one.getCc()+"->"+two.getDest()+"->"+"cost="+total+"->"+time );
	        			String str=one.getSource() +"->"+ one.getCc()+"->"+one.getDest()+"->"+one.getCc()+"->"+two.getDest()+"time="+time;
	        			Optimum o=new Optimum();
	        			o.setS(str);
	        			o.setCost(total);
	        			sort1.add(o);
	        		}
	        	}
	        }
	      
	        
	        for(int i=0;i<sort1.size();i++)
        	{
        		for(int j=i+1;j<sort1.size();j++)
        		{
        			int n1,n2;
        			String s1,s2;
        			
        			s1=sort1.get(i).getS();
        			s2=sort1.get(j).getS();
        			n1=sort1.get(i).getCost();
        			n2=sort1.get(j).getCost();
        			if(n1>n2)
        			{
        				int temp=n1;
        				n1=n2;
        				n2=temp;
        				
        				String temp1=s1;
        				s1=s2;
        				s2=temp1;
        			}
        		}
        	}
	        
	    	for(Optimum i:sort1)
	    	{
	    		System.out.println(i.getS()+" "+i.getCost());
	    	}
	        	/*for(String s:object1){
	        		
	        		String x=object1.get(0);
	        		String y=object1.get(1);
	        	if(tmp!=null)
	        		{
        			

        			while(tmp.next())
        			{
	        		if((x.equals(source1)) || (y.equals(dest1)))
	        		{	
	        			
	        			//Iterator itr = object1.iterator();
	        			//while(itr.hasNext())
	    	        	

	        			 object3.add(tmp.getString("source"));
		                 object3.add(tmp.getString("dest"));
		                 object3.add(tmp.getString("Courier_company"));
		                 object3.add(tmp.getString("cost"));
		                 object3.add(tmp.getString("time"));
		                 //System.out.println(object3);
	        		}
	        		}	
	    		}	
	        	}	
				for(String s:object3)
				{
					System.out.println(s);
				}
	       
	        		for(String s1:object2)
	        		{	
	        			if((object1.get(1)).equals(object2.get(0)))
	        			{   
	        				object3.add(rs.getString("source"));
	        				object3.add(rs.getString("Courier_company"));
		                    object3.add(rs.getString("dest"));
		                    object3.add(rs1.getString("Courier_company"));
		                    object3.add(rs1.getString("dest"));

		                    int fare1=rs.getInt("cost")+rs1.getInt("cost");
		                    String fare=String.valueOf(fare1);
		                    object3.add(fare);
		                    int time1=rs.getInt("time")+rs1.getInt("time");
		                    String time=String.valueOf(time1);
		                    object3.add(time);
	        			}
	        		}*/
	        	
	        
				
	       }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	
	}

}
