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
        IN_PROGRESS,
        CANCEL,
        COMPLETED
    }

    public enum TagType {
        Resume
    }
}
