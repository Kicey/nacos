// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: nacos_grpc_service.proto

package com.alibaba.nacos.api.grpc;

public interface GrpcResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GrpcResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 code = 1;</code>
   */
  int getCode();

  /**
   * <pre>
   * reponse body
   * </pre>
   *
   * <code>.google.protobuf.Any body = 2;</code>
   */
  boolean hasBody();
  /**
   * <pre>
   * reponse body
   * </pre>
   *
   * <code>.google.protobuf.Any body = 2;</code>
   */
  com.google.protobuf.Any getBody();
  /**
   * <pre>
   * reponse body
   * </pre>
   *
   * <code>.google.protobuf.Any body = 2;</code>
   */
  com.google.protobuf.AnyOrBuilder getBodyOrBuilder();
}