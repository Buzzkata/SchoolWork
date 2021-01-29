		TITLE BozhidarA3.ASM

        .MODEL    SMALL
        .STACK    100h

        .DATA

        INCLUDE CONST.INC


      X        DW    ?
      Y        DW    ?
      Z        DW    ?
        OUTMSG1     DB    'Z(x, y) = 27 * x - 14 * y + (10 * x + 17 * y) * (19 * x - 3 * y)'
        INMSG1        DB    CR, LF, 'PLEASE ENTER THE VALUE OF x: $'
        INMSG2        DB    CR, LF, 'PLEASE ENTER THE VALUE OF y: $'
        OUTMSG2        DB    CR, LF, 'THE VALUE OF Z IS: $'

		.CODE

        EXTRN    GETINT: NEAR, PUTINT: NEAR

MAIN    PROC

		MOV     AX, @DATA
        MOV     DS, AX

        MOV     AH, WRSTR
        MOV     DX, OFFSET OUTMSG1
        INT     DOSFUNC

        MOV     AH, WRSTR
        MOV     DX, OFFSET INMSG1
        INT     DOSFUNC

        CALL     GETINT
        MOV     Y, AX
    
        MOV     AH, WRSTR
        MOV     DX, OFFSET INMSG2
    
        CALL     GETINT
        MOV     Y, AX
    
        MOV     AX, 10
        IMUL    Y
        MOV     BX, AX
        MOV     AX, 17
        IMUL    Y
        ADD    AX, BX
        MOV    CX, AX
    
        MOV    AX, 19
        IMUL    Y
        MOV    BX, AX
        MOV    AX, 3
        IMUL    Y
        SUB    BX, AX
        MOV    AX, BX
    
        IMUL    CX
        MOV    CX, AX
    
        MOV    AX, 27
        IMUL    X
        ADD    CX, AX
    
        MOV    AX, 14
        IMUL    Y
        SUB    CX, AX
    
        MOV    Z, CX
    
        MOV    AH, WRSTR
        MOV    DX, OFFSET OUTMSG2
        INT    DOSFUNC
    
       MOV    AX, CX
       CALL    PUTINT

        MOV    AH, RET2DOS
        INT    DOSFUNC

MAIN    ENDP

    END        MAIN