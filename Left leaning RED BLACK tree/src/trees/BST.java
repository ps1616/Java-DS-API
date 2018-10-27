package trees;

import java.util.Iterator;

public class BST<K extends Comparable<K>,V> implements Iterable<K> {

	private Node root=null;
	private final boolean RED=false;
	private final boolean BLACK=true;
	
	public int height()
	{
		return height(root);
	}
	
	private int height(Node n)
	{
		if(n==null)
			return 0;
		return 1+Math.max(height(n.left), height(n.right));
	}
	
	public void add(K key,V val)
	{
		System.out.println("inserting "+ key);
		root=add(root,key,val);
		root.color=BLACK;
		System.out.println("**done**");
	}
	
	private boolean getColor(Node n)
	{
		if(n==null)
			return BLACK;
		return n.color;
	}
	
	public V get(K key)
	{
		Node n=get(root,key);
		return n==null?null:n.val;
	}
	
	private Node get(Node n,K key)
	{
		if(n==null)
			return null;
		int cmp=key.compareTo(n.key);
		if(cmp==0)
			return n;
		
		return (cmp>0?get(n.right,key):get(n.left,key));
	}
	
	private Node add(Node n,K key,V val)
	{
		if(n==null)
			return new Node(key,val);
		int cmp=key.compareTo(n.key);
		if(cmp==0)
			n.val=val;
		else if(cmp>0)
			n.right=add(n.right,key,val);
		else
			n.left=add(n.left,key,val);
		
		if(getColor(n.left)==BLACK && getColor(n.right)==RED)
			n=leftRotate(n);
		
		if(getColor(n.left)==RED && getColor(n.left.left)==RED)
			n=rightRotate(n);
		
		if(getColor(n.left)==RED && getColor(n.right)==RED)
			n=swapColor(n);
		return n;
	}
	
	private Node leftRotate(Node n)
	{
		System.out.println("left rotate on "+n.val);
		Node t=n.right;
		n.right=t.left;
		t.left=n;
		
		t.color=n.color;
		n.color=RED;
		
		return t;
	}
	
	private Node rightRotate(Node n)
	{
		System.out.println("right rotate on "+n.val);
		Node t=n.left;
		n.left=t.right;
		t.right=n;
		
		t.color=n.color;
		n.color=RED;
		
		return t;
	}
	
	private Node swapColor(Node n)
	{
		System.out.println("color swap on "+n.val);
		n.left.color=n.color;
		n.right.color=n.color;
		n.color=RED;
		return n;
	}
	
	
	private class Node{
	
		private K key;
		private V val;
		private Node left=null;
		private Node right=null;
		private boolean color;
		
		public Node(K key,V val)
		{
			this.key=key;
			this.val=val;
		}
	}
	
	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
