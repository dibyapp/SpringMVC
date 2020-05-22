package com.dib.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingCommand
{
    private int pagesize;	
    private int pageno=1;
}
