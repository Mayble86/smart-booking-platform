package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Serve;
import com.olegf.spingapp.smartbookingplatform.domain.mapper.ServeMapper;
import com.olegf.spingapp.smartbookingplatform.domain.repository.ServeRepo;
import com.olegf.spingapp.smartbookingplatform.web.dto.serve.ServeCreateRequest;
import com.olegf.spingapp.smartbookingplatform.web.dto.serve.ServeResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ServeService {
    private final ServeRepo serveRepo;
    private final ServeMapper serveMapper;

    public List<ServeResponse> findAll(int page, int size) {
        return serveRepo.findAll(PageRequest.of(page, size))
                .map(serveMapper::toResponse)
                .getContent();
    }

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ServeResponse create(ServeCreateRequest dto) {
        Serve serve = serveMapper.toEntity(dto);
        return serveMapper.toResponse(serveRepo.save(serve));
    }
}
