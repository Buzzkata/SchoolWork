		TITLE A4    ; evaluate function Z(x, y)

        .MODEL    SMALL
        .STACK    100h

        .DATA

        INCLUDE CONST.INC


	n        DW    ?
	msgEven    DB    'n is even$'
	msgOdd3    DB    CR, LF,'n is odd and divisible by 3$'
    msgOdd5    DB    CR, LF,'n is odd and divisible by 5$'
    msgOdd    DB    CR, LF,'n is odd$'
    msg9    DB    CR, LF,'n is also divisible by 9 (Consider sum of digits of n)$'

	.CODE

	EXTRN  GETINT: near, PUTINT: near
	

MAIN PROC

    mov AX,    @DATA
    mov DS,    AX

    ; read n
    CALL GETINT
    mov n, AX

    ; n/2=n , if01 condition01
    mov AX,    n
    mov BX,    2
    cwd
    idiv BX
    imul BX
    cmp AX, n
    jne elif01

outputone:
    mov AH, wrstr
    mov DX,    OFFSET msgEven
    int DOSFUNC
    jmp if01
outputtwo:
    mov AH, wrstr
    mov DX, OFFSET msgOdd3
    int DOSFUNC
    jmp elif02
outputthree:
    mov AH, wrstr
    mov DX, OFFSET msgOdd5
    int DOSFUNC
    jmp if01
outputfour:
    mov AH, wrstr
    mov DX, OFFSET msgOdd
    int DOSFUNC
    jmp if01
outputfive:
    mov AH, wrstr
    mov DX, OFFSET msg9
    int DOSFUNC
    jmp end01


elif01:
    ; n/3=n
    mov AX,    n
    mov BX,    3
    cwd
    idiv BX
    imul BX
    cmp AX, n
    je outputtwo


elif02:
    ; n/5=n
    mov AX,    n
    mov BX,    5
    cwd
    idiv BX
    imul BX
    cmp AX, n
    je outputthree
    jne outputfour

if01:
    ; n/9
    mov AX,    n
    mov BX,    9
    cwd
    idiv BX
    imul BX
    cmp AX, n
    je outputfive
    jmp end01


end01:
    MAIN ENDP
    END MAIN		