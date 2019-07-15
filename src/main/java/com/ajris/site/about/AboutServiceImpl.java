package com.ajris.site.about;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public List<AboutInformation> getAllAboutInformations() {
        return aboutRepository.findAll();
    }
}
