	title A7 ; Hofstadter Q sequence, by Bozhidar Stoyanov 0353616
	.model small
	.data
	include const.inc
t1	equ	word ptr 2[bp]
t2	equ	word ptr 4[bp]
t3	equ	word ptr 6[bp]
t4	equ	word ptr 8[bp]
m	dw	?
n	dw	?
t	dw	?
	.code

	public	q
q	proc
	push	bp
	mov	bp, sp
	mov	bx, word ptr [bp]
	mov	m, bx
	mov	bx, word ptr 2[bp]
	mov	n, bx
	push	t4
	push	t3
	push	t2
	push	t1
; if01 n = 1
	mov	bx, 1
	cmp	n, bx
	jne	else01
; then01 t := 1
	mov	t, 1
	jmp	endif01
; elsif01 n = 2
	mov	bx, 2
	cmp	n, bx
	jne	else01
; then01a t := 1
	mov	t, 1
	jmp	endif01
else01:
; if02 if m[ n] != 0
	mov	bx, n
	cmp	m[ bx], 0
	add	bx, 2
	jne	else02
; then02 t := m[ n]
	mov	dx, m[ bx]
	mov	t, dx
	add	bx, 2
	jmp	endif02
else02:
; t1 := Q( n - 1, m);
	dec	n
	push	n
	push	m
	call	q
	pop	m
	pop	n
; t2 := Q( n - 2, m);
	dec	n
	push	n
	push	m
	call	q
	pop	m
	pop	n
; t3 := Q( n - t1, m);
	mov	dx, t1
	sub	n, dx
	push	n
	push	m
	call	q
; t4 := Q( n - t2, m);
	mov	dx, t2
	sub	n, dx
	push	n
	push	m
	call	q
	pop	m
	pop	n
; t  := t3 + t4;
	mov	dx, t4
	add	t3, dx
	mov	dx, t3
	mov	t, dx
; m[ n] := t
	mov	dx, t
	mov	m[ bx], dx
endif02:
endif01:
	mov	ax, m[ bx]
; return t
	pop	t1
	pop	t2
	pop	t3
	pop	t4
	mov	sp, bp
	pop	bp
	ret
q	endp
	end