	title binco
	.model small
	
	public binco
	.code
binco proc ;binco(n,r)
	push si
	push di
	pushf
;if r > n-r	
	sub si, di
	cmp di, si
	jng endif01
;then r = n-r	
	mov di, si
endif01:
	push di
	push di
	call fp
	mov bx, ax
	
	push si
	push di
	call fp
	cwd
	idiv bx
	
	popf
	pop di
	pop si
	ret
binco endp
	end
	