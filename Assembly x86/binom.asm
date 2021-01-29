	title binom ;binom by Bozhidar Stoyanov
	.model small
	.stack 1000h
	.data
	include const.inc
n		dw		?
r 		dw 		?
nstr 	db		cr, lf, 'n: $'
rstr	db 		cr, lf, 'r: $'
crlf	db 		cr, lf, '$'
	.code
	extrn binco: proc, getint: proc, putint: proc
binom proc
	mov		ax, @data
	mov 	ds, ax
	
loop01:
;write 'n: '
	mov		 dx, offset nstr
	mov		 ah, wrstr
	int		 dosfunc
;read n
	call getint
	mov n, ax
;write 'r: '
	mov		 dx, offset rstr
	mov		 ah, wrstr
	int		 dosfunc
;read r
	call getint
	mov r, ax
;exit when r<0
	cmp r, 0
	jl endloop01
	
;write binco(n,r)
	push 	n
	push 	r
	call 	binco
	call 	putint
;write cr,lf	
	mov		 dx, offset crlf
	mov		 ah, wrstr
	int		 dosfunc
	
	jmp 	loop01
endloop01:
;return
	mov 	ah, ret2dos
	int		dosfunc
binom endp
	end 	binom
	
