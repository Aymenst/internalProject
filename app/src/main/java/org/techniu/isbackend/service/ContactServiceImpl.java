package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.ContactMapper;
import org.techniu.isbackend.dto.model.ContactDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Contact;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.AddressRepository;
import org.techniu.isbackend.repository.CityRepository;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    private ClientRepository clientRepository;
    private CityRepository cityRepository;
    private AddressRepository addressRepository;
    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);
    ContactServiceImpl(ContactRepository contactRepository, ClientRepository clientRepository, CityRepository cityRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.clientRepository = clientRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public void save(ContactDto contactDto, String companyId, Address address, String cityId) {
        // save Client if note existe
       Client client = clientRepository.getBy_id(companyId);
        System.out.println(cityId);
        City city =cityRepository.findCityBy_id(cityId);
        System.out.println(city);
        Optional<Contact>  contact= Optional.ofNullable(contactRepository.findByPersonalEmail(contactDto.getPersonalEmail()));
        if (contact.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        Contact contact1=contactMapper.dtoToModel(contactDto);
        contact1.setClient(client);
        contact1.setAddress(addressRepository.save(address.setCity(city)));
        contactRepository.save(contact1);
    }

    @Override
    public void update(ContactDto contactDto) {
        // save Contact if note existe
       Optional<Contact> contact1 = Optional.ofNullable(contactRepository.findBy_id(contactDto.getContactId()));
        if (!contact1.isPresent()) {
            throw exception(ExceptionType.ENTITY_NOT_FOUND);
        }
        Optional<Contact> contact2 = Optional.ofNullable(contactRepository.findByPersonalEmail(contactDto.getPersonalEmail()));

        if (contact2.isPresent() && !(contact1.get().getPersonalEmail().equals(contactDto.getPersonalEmail())) ) {
            throw exception(DUPLICATE_ENTITY);
        }
         contactRepository.save(contactMapper.dtoToModel(contactDto));
    }

    @Override
    public List<ContactDto> getAll() {
        // Get all Contacts
        List<Contact> contacts = contactRepository.findAll();
        // Create a list of all Contacts dto
        ArrayList<ContactDto> contactDtos = new ArrayList<>();

        for (Contact contact : contacts) {
            ContactDto contactDto=contactMapper.modelToDto(contact);
            contactDtos.add(contactDto);
        }
        return contactDtos;
    }
    /**
     * delete Contact
     *
     * @param id - id
     */
    @Override
    public void remove(String id) {
        Optional<Contact> action = Optional.ofNullable(contactRepository.findBy_id(id));
        // If Contact doesn't exists
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        contactRepository.deleteById(id);
    }


    /**
     * Returns a new RuntimeException
     *
     * @param exceptionType exceptionType
     * @param args  args
     * @return RuntimeException
     */
    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.Contact, exceptionType, args);
    }
}
