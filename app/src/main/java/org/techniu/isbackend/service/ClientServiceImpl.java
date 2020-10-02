package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.repository.AddressRepository;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.service.utilities.StringUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;
    private AddressRepository addressRepository;
    ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository ) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;

    }
    @Override
    public Client saveClient(Client client) {
        String country = client.getAddress().getCity().getStateCountry().getCountry().getCountryName().length() > 3 ? client.getAddress().getCity().getStateCountry().getCountry().getCountryName().substring(0,3).toUpperCase() : client.getAddress().getCity().getStateCountry().getCountry().getCountryName().toUpperCase();
        int len = clientRepository.findAll().size();
        String code;
        Address address = addressRepository.save(client.getAddress());
        client.setAddress(address);
        if (len < 9) {
            len+=1;
            code = country + "-00" + len;
            client.setCodeClient(code);
            return clientRepository.save(client);
        }
        if (len < 99) {
            len+=1;
            code = country + "-0" + len;
            client.setCodeClient(code);
            return clientRepository.save(client);
        } else {
            len+=1;
            code = country + "-" + len;
            client.setCodeClient(code);
            return clientRepository.save(client);
        }
    }

    @Override
    public Client getClientByCode(String codeClient) {
        return clientRepository.getByCodeClient(codeClient);
    }

    @Override
    public Client updateClient(String clientId, Client client) {
        return clientRepository.findById(clientId).map(client1 -> {
            client.setClientId(client1.getClientId());
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
