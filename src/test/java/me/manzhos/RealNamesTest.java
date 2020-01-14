package me.manzhos;

import me.manzhos.model.RealNamesModel;
import org.testng.annotations.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RealNamesTest {

    private final String URI = "https://gentle-journey-86001.herokuapp.com/real-names/generate";
    private RealNamesModel realNamesModel = new RealNamesModel();

    @Test
    public void getRealNames(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(URI);

        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE).get();

        realNamesModel = response.readEntity(RealNamesModel.class);
        System.out.println(realNamesModel.toString());
        System.out.println(realNamesModel.getFirstName());
        System.out.println(realNamesModel.getLastName());
        System.out.println(realNamesModel.getFullName());
    }
}
