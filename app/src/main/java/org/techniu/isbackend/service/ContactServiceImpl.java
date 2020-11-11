package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.ContactMapper;
import org.techniu.isbackend.dto.model.ContactDto;
import org.techniu.isbackend.dto.model.ContactDto;
import org.techniu.isbackend.entity.Contact;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);
    ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public void save(ContactDto contactDto) {
        // save country if note existe
        Optional<Contact>  contact= Optional.ofNullable(contactRepository.findByPersonalEmail(contactDto.getPersonalEmail()));
        if (contact.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        contactRepository.save(contactMapper.dtoToModel(contactDto));
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
