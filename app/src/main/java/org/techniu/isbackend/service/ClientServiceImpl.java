package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.AddressRepository;
import org.techniu.isbackend.repository.CityRepository;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;
    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private AddressService addressService;
    private StaffService  staffService;
    private StaffRepository staffRepository;
    ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository, AddressService addressService,StaffService  staffService,
                      StaffRepository staffRepository,CityRepository cityRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
        this.staffRepository = staffRepository;
        this.cityRepository = cityRepository;
        this.staffService = staffService;
    }
    @Override
    public void saveClient(Client client,Address address,String cityId,String AssistantCommercialId,String responsibleCommercialId) {
        int len = this.getAllClient().size();
        String code;
        City city=cityRepository.findCityBy_id(cityId);
        String country = city.getStateCountry().getCountry().getCountryName().length() > 3 ? city.getStateCountry().getCountry().getCountryName().substring(0,3).toUpperCase() : city.getStateCountry().getCountry().getCountryName().toUpperCase();
        if (len < 9) {
            len+=1;
            code = country + "-00" + len;
            client.setCode(code);
        }
        if (len < 99) {
            len+=1;
            code = country + "-0" + len;
            client.setCode(code);
        } else {
            len+=1;
            code = country + "-" + len;
            client.setCode(code);
        }
        Staff AssistantCommercial = staffRepository.findBy_id(AssistantCommercialId);
        Staff responsibleCommercial = staffRepository.findBy_id(responsibleCommercialId);
        client.setAddress(addressService.saveAddress(address.setCity(city)));
        client.setAssistantCommercial(AssistantCommercial);
        client.setResponsibleCommercial(responsibleCommercial);
        clientRepository.save(client);
    }

    @Override
    public Client getClientByCode(String codeClient) {
        return clientRepository.getByCode(codeClient);
    }

    @Override
    public Client updateClient(String clientId, Client client) {
        return clientRepository.findById(clientId).map(client1 -> {
            client.set_id(client1.get_id());
            return clientRepository.save(client);
        }).orElseThrow(() -> new ExceptionMessage("Cannot update client"));
    }

    @Override
    public ResponseEntity<?> deleteClient(String clientId) {
        return null;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClientsByCountryName(String country) {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().filter(client -> client.getAddress().getCity().getStateCountry().getCountry().getCountryName().equals(country)).collect(Collectors.toList());
    }
}
