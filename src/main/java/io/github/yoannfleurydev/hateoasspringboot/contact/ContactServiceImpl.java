package io.github.yoannfleurydev.hateoasspringboot.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getContact(String id) {
        return this.contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(String.format("%s not found", id)));
    }

    @Override
    public void postContact(Contact contact) {
        this.contactRepository.save(contact);
    }

    @Override
    public Page<Contact> getContacts(Pageable pageable) {
        return this.contactRepository.findAll(pageable);
    }
}
