        title getint.asm        ; procedure to input decimal integers

        comment /

 PROCEDURE getint
    REPEAT
       err := false
       neg := false
       N := 0
       REPEAT
          read char
       UNTIL char <> ' '
       IF char = '+' THEN
           read char
       ELSIF char = '-' THEN
           neg := true
           read char
       ENDIF
       IF char IN '0' .. '9' THEN
          REPEAT
             N := 10 * N + digit( char)
             read char
          UNTIL not char IN '0' .. '9'
          WHILE char = ' ' DO
             read char
          ENDWHILE
          IF char <> cr THEN
             err := true
          ENDIF
       ELSE
          err := true
       ENDIF
       IF err THEN
          write nl, errmsg, nl
       ENDIF
    UNTIL NOT err 
    IF neg THEN
       N := - N
    ENDIF
 END getint
        /

        .model  small
        .data
        include const.inc
errmsg  db      cr, lf, 'INPUT ERROR: RE-ENTER NUMBER', cr, lf, '$'

        .code

        public  getint
getint  proc    ;( N)

; read number N in range -32767 to 32767
; input: none
; output: AX contains binary equivalent of number N
; uses: none
; warning: no check for overflow

        push    BX
        push    CX
        push    DX

repeat01:
; N := 0
        xor     BX, BX
; err := false
        xor     CL, CL
; neg := false
        xor     CH, CH
        mov     AH, readkbe

repeat02:
; read char
        int     dosfunc
; until02 char <> ' '
        cmp     al, ' '
        je      repeat02

; if03 char = '+'
        cmp     AL, '+'
        jne     elsif03
; then03
; read char
        int     dosfunc
        jmp     endif03
elsif03:        ; char = '-'
        cmp     AL, '-'
        jne     endif03
; then03a
; neg := true
        mov     ch, 1
; read char
        int     dosfunc
endif03:

; if04 char in '0' .. '9' 
        cmp     AL, '0'
        jnge    else04
        cmp     AL, '9'
        jnle    else04
; then04

repeat05:
; N := 10 * N + digit( char)
        and     AX, 000Fh       ; convert character to digit
        push    AX              ; save value
        mov     AX, 10
        mul     BX
        pop     BX
        add     BX, AX
; read char
        mov     AH, readkbe
        int     dosfunc
; until05 not char in '0' .. '9'
        cmp     AL, '9'
        jnle    endrepeat05
        cmp     AL, '0'
        jge     repeat05
endrepeat05:

while06:        ; char = ' '
        cmp     AL, ' '
        jne     endwhile06
; do06
; read char
        int     dosfunc
        jmp     while06
endwhile06:

; if07 char <> cr 
        cmp     al, cr
        je      endif07
; then07
; err := true
        mov     cl, 1
endif07:

        jmp     endif04
else04:
; err := true
        mov     cl, 1
endif04:

; if08 err
        cmp     cl, 1
        jne     endif08
; then08
; write nl, errmsg, nl
        mov     ah, dispstr
        mov     dx, offset errmsg
        int     dosfunc
endif08:

; until01 not err
        or      cl, cl
        jne     repeat01

        mov     AX, BX
; if09 neg
        or      CH, CH
        je      endif09
; then09
; N := - N
        neg     AX
endif09:

        pop     DX
        pop     CX
        pop     BX
        ret
getint  endp

        end