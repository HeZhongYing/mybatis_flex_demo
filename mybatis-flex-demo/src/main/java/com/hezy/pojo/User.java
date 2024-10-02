package com.hezy.pojo;

import com.mybatisflex.annotation.*;
import com.mybatisflex.core.mask.Masks;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("i_users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column
    private String username;

    private String password;

    @ColumnMask(Masks.MOBILE)
    private String phone;

    @Column(isLogicDelete = true)
    private boolean deleted;

    @Column(onInsertValue = "now()")
    private Date createDate;

    @Column(onUpdateValue = "now()")
    private Date updateDate;
}
