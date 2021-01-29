	title Q ; Hofstadter Q sequence, by Bozhidar Stoyanov 0353616
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

	public	Q
Q	proc
	push	bp
	mov		bp, sp
	mov		bx, word ptr [bp]
	mov		m, bx
	mov		bx, word ptr 2[bp]
	mov		n, bx
	push 	dx
	pushf
; if01 n = 1
	cmp		n, 1
	jne		else01
; then01 t := 1
	mov		t, 1
	jmp		endif01
; elsif01 n = 2
	cmp		n, 2
	jne		else01
; then01a t := 1
	mov		t, 1
	jmp		endif01
else01:
; if02 if m[ n] != 0
	mov		bx, n
	cmp		m[ bx], 0
	jne		else02
; then02 t := m[ n]
	mov		dx, m[ bx]
	mov		t, dx
	jmp		endif02
else02:
; t1 := Q( n - 1, m);
	dec		n
	push	n
	mov 	ax, m
	push	ax
	call	Q
	mov		t1, ax
	pop		ax
	pop		n
; t2 := Q( n - 2, m);
	dec		n
	push	n
	mov 	ax, m
	push	ax
	call	Q
	mov 	t2, ax
	pop		ax
	pop		n
; t3 := Q( n - t1, m);
	mov	dx, t1
	sub	n, dx
	push	n
	mov 	ax, m
	push	ax
	call	Q
	mov 	t3, ax
	pop 	ax
	pop 	n
; t4 := Q( n - t2, m);
	mov		dx, t2
	sub		n, dx
	push	n
	mov 	ax, m
	push	ax
	call	Q
	mov 	t4, ax
	pop		ax
	pop		n
; t  := t3 + t4;
	mov		dx, t4
	add 	dx, t3
	mov		t, dx
; m[ n] := t
	mov		dx, t
	mov		m[ bx], dx
endif02:
endif01:
	mov		ax, m[ bx]
; return t
	pop		t1
	pop		t2
	pop		t3
	pop		t4
	mov		sp, bp
	pop		bp
	ret
Q	endp
	end