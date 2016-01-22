

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    //declaring final answer as variable with type of double array
    public int[][] answer;
    //declaring logger 
    private static Logger log = LogManager.getRootLogger();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//grabbing the value of parameter 1 from query string send from mobile device
		String input = request.getParameter("param1");
		int a = Integer.parseInt(input);
		
		//time stamp for the start of Computation class
		long start = System.nanoTime();
		//getting final answer from Computation class
		answer = Computation.matrice(a, a);
		//time stamp for the end of Computation class
		long end = System.nanoTime();
		
		//printing out final answer
  	   	PrintWriter out = response.getWriter();
  	   	out.print(Computation.toString(answer));
  	   	
  	   	//logging the time taken to execute Computation class
  	   	long t = end - start;
  	   	long tm = (end-start)/1000000;
  	  log.info("With parameter: "+a+" Remote Computation time: " +t+ " nS or " +tm+" mS");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
