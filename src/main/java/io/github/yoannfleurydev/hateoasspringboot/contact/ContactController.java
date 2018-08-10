package io.github.yoannfleurydev.hateoasspringboot.contact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactController {

    private final ContactService contactService;
    private final ContactAssembler contactAssembler;

    @Autowired
    public ContactController(ContactService contactService, ContactAssembler contactAssembler) {
        this.contactService = contactService;
        this.contactAssembler = contactAssembler;
    }

    @PostMapping
    public HttpEntity<ContactResource> postContact(@RequestBody @Valid ContactResource contactResource, Principal principal) {

        Contact contact = this.contactAssembler.toEntity(contactResource);
        this.contactService.postContact(contact);

        return ResponseEntity
                .created(linkTo(methodOn(ContactController.class)
                        .getContact(contact.getId()))
                        .toUri())
                .body(this.contactAssembler.toResource(contact));
    }

    @GetMapping("/{id:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}}")
    public HttpEntity<ContactResource> getContact(@PathVariable String id) {
        return ResponseEntity.ok(
                this.contactAssembler.toResource(
                        this.contactService.getContact(id)
                )
        );
    }


    @GetMapping
    public HttpEntity<Page<ContactResource>> getContacts(Pageable pageable) {
        Page<Contact> contacts = this.contactService.getContacts(pageable);

        return ResponseEntity.ok(contacts.map(this.contactAssembler::toResource));
    }
}
