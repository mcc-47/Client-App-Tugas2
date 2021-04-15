package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.config.RequestFormat;
import mii.co.id.clientappmcc.models.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProvinceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String url;

    //READ
    public List<Province> getAll() {
        ResponseEntity<List<Province>> res = restTemplate
                .exchange(url + "/list-province", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<Province>>() {
                });
        return res.getBody();
    }

    //GET BY ID
    public Province getById(Integer id) {
        return restTemplate.getForEntity(url + "/provinceBy/" + id, Province.class).getBody();
    }

    //CREATE 
    public Province create(Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url + "/insert", HttpMethod.POST, entity,
                new ParameterizedTypeReference<Province>() {

        });
        return res.getBody();
    }

    //UPDATE
    public Province update(Integer id, Province province) {
        HttpEntity entity = new HttpEntity(province);
        ResponseEntity<Province> res = restTemplate.exchange(url + "/update/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<Province>() {
        });
        return res.getBody();
    }

    //DELETE
    public Province delete(Integer id) {
        HttpEntity entity = new HttpEntity(id, RequestFormat.createHeaders());
        ResponseEntity<Province> res = restTemplate.exchange(url + "/delete/" + id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<Province>() {
        });
        return res.getBody();
    }

}
