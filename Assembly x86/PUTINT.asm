        title   PUTINT.asm      ; procedure to output an integer
        .model  small
        .data
        include const.inc
        .code

        comment #

PROCEDURE putint( N)
   IF N < 0 THEN
      write '-'
      N := - N
   ENDIF
   count := 0
   REPEAT
      dig := N mod 10
      push dig
      N := N div 10
      count := count + 1
   UNTIL N = 0
   FOR i := count DOWNTO 1 DO
      pop dig
      char := dig + '0' -- convert to character
      write char
   ENDFOR
END putint

        #

        public  putint
putint  proc    ;( N)

; print N as signed decimal integer
; input: AX
; output: none
; uses: none

        push    AX      ; save registers
        push    BX      ; divisor 10
        push    CX      ; assigned to count
        push    DX      ; upper half of dividend

; if01 N < 0
        or      AX, AX
        jnl     endif01
; then01
; write '-'
        push    AX
        mov     AH, dispchr
        mov     DL, '-'
        int     dosfunc
        pop     AX
; N := - N
        neg     AX
endif01:

; get decimal digits
; count := 0
        xor     CX, CX
        mov     BX, 10
repeat02:
; dig := N mod 10
; N := N div 10
        xor     DX, DX  ; zero upper half of dividend
        div     BX
; push dig
        push    DX
; count := count + 1
        inc     CX
; until02 N = 0
        or      AX, AX
        jne     repeat02

; convert digits to characters and print
; for03 i := count downto 1
        mov     AH, dispchr
do03:
; pop dig
        pop     DX
; char := dig + '0'
        or      DL, 30h ; convert to char
; write char
        int     dosfunc
        loop    do03
; endfor03

        pop     DX      ; restore registers
        pop     CX
        pop     BX
        pop     AX
        ret
putint  endp
        end