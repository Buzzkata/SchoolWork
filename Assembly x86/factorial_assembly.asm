title a6
.model small
k dw ?
f dw ?
public a6
.code
a6	proc ; fp(n,r)
	push si
	push di
	pushf

;if r = 0
	cmp di, 0
	jne else01
;then f = 1
	mov f, 1
	jmp endif01
;else if r = 1
else01:
	cmp di, 1
	jne else02
;then f = n
	mov f, si
	jmp endif01
else02:
	mov f, 1
	for k=0 to r-1
	;f=f*(n-k) factorial in for loop

endfor
endif01:
	mov ax, f
	popf
	pop di
	pop si
	ret
a6 endp