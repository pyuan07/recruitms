package com.recruit.recruitms.service;

import com.recruit.recruitms.dto.request.ExtractTagsRequest;
import com.recruit.recruitms.entity.Tag;

import java.util.List;

public interface ITagService {

    Tag getByName(String name);
    List<Tag> extractTagFromString(ExtractTagsRequest request);
}
