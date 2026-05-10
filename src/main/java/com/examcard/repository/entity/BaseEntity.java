package com.examcard.repository.entity;

import lombok.Data;

@Data
public abstract class BaseEntity {
  private String createdAt;
  private String createdBy;
  private String updatedAt;
  private String updatedBy;
  private String isDeleted;
  private String deletedAt;
  private String deletedBy;
}
