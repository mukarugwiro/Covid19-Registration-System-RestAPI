/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Domain.Patient;
import Domain.users;
import GDAO.Dao;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;
import static org.hibernate.annotations.SourceType.DB;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("service")
public class RestService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    public RestService() {
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<Patient>  getList(){
       Dao dao = new Dao();
       return dao.retrieveall();
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient  putCreate(@FormParam("nationId") String nationId,@FormParam("code") String code,@FormParam("firstName") String firstName,@FormParam("lastName") String lastName,@FormParam("gender") String gender,@FormParam("vSite") String vSite,@FormParam("vDate") String String_vDate,@FormParam("vname") String vname,@FormParam("vac") String vac) {
        LocalDate vDate = LocalDate.parse(String_vDate);
         //Patient pt = new Patient(nationId,code, firstName, lastName, gender, vSite, vDate, vname, vac);
        Patient pt = new Patient();
        pt.setNationId(nationId);
        pt.setCode(code);
        pt.setFirstName(firstName);
        pt.setLastName(lastName);
        pt.setGender(gender);
        pt.setVaccine_Site(vSite);
        pt.setVaccination_Date(vDate);
        pt.setVaccine_Name(vname);
        pt.setVaccine(vac);
     
      Dao dao = new Dao(); 
     dao.save(pt);
     return pt; 
      
}
@GET
@Path("/{nationId}")
public Response getDelete(@QueryParam("nationId") String nationId){
    try{
    Patient patient= new Patient();
    patient.setNationId(nationId);
    
    Dao dao = new Dao();
  dao.delete(patient);
     URI uri = new URI("http://localhost:8080/App1/Display.jsp");
     return Response.temporaryRedirect(uri).build();
    }catch (Exception e){
     String output = "An error occured";
     return Response.status(200).entity(output).build();
    }
   
}

//@GET
//@Path("/{firstDose}")
//public Response getFirst(@QueryParam("nationId") String nationId){
// try {
//        String second = "2nd Dose";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
//        PreparedStatement pst = conn.prepareStatement("UPDATE patient SET vaccine = '"+second+"' WHERE nationId='"+nationId+"'");
//        pst.executeUpdate();
//        URI uri = new URI("http://localhost:8080/App1/Display.jsp");
//        return Response.temporaryRedirect(uri).build();
//    } catch (Exception e) {
//          String output = "An error occured "+e;
//       return Response.status(200).entity(output).build();
//    }
//}

//@POST
// @Path("login")
//    public Response authenticate(@FormParam("Username") String username,@FormParam("password") String password) {
//
//                        int counter = 0;
//                        List<users> UserList = new ArrayList<>();
//                        try{
//                               
//                       Class.forName("com.mysql.jdbc.Driver");
//                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
//                       Statement st = conn.createStatement();
//                       ResultSet rs = st.executeQuery("select * from User where username='"+username+"' and password='"+password+"'");
//
//                        while (rs.next()){     
//                           counter = counter +1; 
//                           users u = new users(rs.getString("username"), rs.getString("password"));
//                           UserList.add(u);
//                        }
//                        rs.close();
//                        if(counter==1){
//                            URI url= new URI("http://localhost:8080/App1/form.jsp");
//                            return Response.temporaryRedirect(url).build();
//                        }else{
//                            String message = "There%20was%20an%20error,%20Please%20try%20again";
//                            URI url= new URI("http://localhost:8080/App1/login.jsp?message="+message);
//                            return Response.temporaryRedirect(url).build();
//                        }
//                   }catch(Exception ex){
//                      
//                     String output="an error occured";
//                        return Response.status(200).entity(output).build();
//
//                   }
//                         
//    }

//@GET
//@Path("/checklogin")
//@Produces("text/plain")
//public String checklogin(@HeaderParam("authentication") String auth){
//    System.out.println(auth);
//    if(isAuthentication(auth)){
//  
//        return "success";
//        }
//    return "errors";
//
//}
//protected EntityManager getEntityManager(){
//
//return em;}
//  public boolean authenticate(String userName,String password){
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery query = cb.createQuery();
//        Root<users> root = query.from(users.class);
//        query.where(
//        cb.equal(root. get("userName"), userName),
//        cb.equal(root.get("password"),password)
//        );
//        TypedQuery<users> tq = getEntityManager().createQuery(query);
//       
//        try {
//            users s = tq.getSingleResult();
//            return true;
//        } catch (NoResultException e) {
//            return false;
//        }
//    }
@POST
@Path("update")
public Response updatePatient(@FormParam("nationId") String nationId,@FormParam("code") String code,@FormParam("firstName") String firstName,@FormParam("lastName") String lastName,@FormParam("gender") String gender,@FormParam("vSite") String vSite,@FormParam("vDate") String String_vDate,@FormParam("vname") String vname,@FormParam("vac") String vac){
try{
                       //Class.forName("com.mysql.jdbc.Driver");
                  //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                    //   PreparedStatement pst= conn.prepareStatement("UPDATE staff Set Vaccine='"+vac+"'  WHERE nationId='"+nationId+"'");
//pst.executeUpdate();
    Patient patient= new Patient();
    
    Dao dao = new Dao();
  dao.updatePatient(patient);
   
        URI uri = new URI("http://localhost:8080/App1/Display.jsp");
        return Response.temporaryRedirect(uri).build();
}catch(Exception ex){}    
       String output="an error occured";
                        return Response.status(200).entity(output).build();
    
}
}