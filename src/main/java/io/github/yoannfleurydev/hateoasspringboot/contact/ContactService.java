package io.github.yoannfleurydev.hateoasspringboot.contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface ContactService {

    Contact getContact(String id);

    void postContact(Contact contact);

    Page<Contact> getContacts(Pageable pageable);

}
