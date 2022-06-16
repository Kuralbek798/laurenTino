package com.example.laurentino.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Image {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id")
    private Long id;
@Column(name = "name")
    private String name;
@Column(name = "original_file_name")
    private String originalFilename;
@Column(name = "size")
    private Long size;
@Column(name = "content_type")
    private String contentType;
@Column(name = "is_preview_image")
    private boolean isPreviewImage;
@Lob
    private byte[] bytes;
@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;

    /*public String getOriginalFileName() {
    }*/
}
