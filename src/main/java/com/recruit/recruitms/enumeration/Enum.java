package com.recruit.recruitms.enumeration;

public class Enum {

    public enum Role {
        ADMIN,
        EMPLOYER,
        STAFF,
        CANDIDATE
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public enum ObjectState {
        CREATED,
        TERMINATED,
        ACTIVE,
        PENDING,
        DRAFT,
        FROZEN
    }

    public enum ApplicationStatus{
        APPLIED,
        VIEWED,
        SHORTLISTED,
        DECLINED,
        CANCEL,
        COMPLETED
    }

    public enum TagType {
        Resume,
        Vacancy
    }

    public enum InterviewApproach {
        ONLINE,
        FACE_TO_FACE
    }
}
