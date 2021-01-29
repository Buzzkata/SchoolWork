	title qtest.asm
	.model small
	.stack 1000h
	.data
	include const.inc
n	dw		?
arr db 		1,2,3,4,6
crlf	db 		cr, lf, '$'
	.code
	extrn A7:proc, getint: proc, putint: proc
qtest proc
	mov		ax, @data
	mov 	ds, ax
	
loop01:
;read n
	call getint
	mov n, ax
	
;exit when n<0
	cmp n, 0
	jl endloop01
	
;write Q(n)
	push 	n
	push 	arr
	call 	A7
	call 	putint
	
	mov		 dx, offset crlf
	mov		 ah, wrstr
	int		 dosfunc
	
	jmp 	loop01
endloop01:
;return
	mov 	ah, ret2dos
	int		dosfunc
qtest endp
	end 	qtest
	
