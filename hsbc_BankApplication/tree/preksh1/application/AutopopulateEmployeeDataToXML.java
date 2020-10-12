import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;  


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Marshaller;  
import com.wechat.entity.Employee;
public class AutopopulateEmployeeDataToXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Employee emp=new Employee();
emp.setEmpid(987654);
emp.setName("ram");
emp.setUsername("ram1");
emp.setPassword("ram12");

try {
	JAXBContext jaxbContext=JAXBContext.newInstance(Employee.class);
	Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(emp, new StreamResult("D:\\exaaam\\Documentation\\employee.xml"));
	
}catch(JAXBException e) {
	e.printStackTrace();
}
	}

}
