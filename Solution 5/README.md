# 5. Remove duplicates on email thread:
When different email clients are used on a same thread, the discussion get messy
because old messages are included again and get duplicated. Given a email thread
(represented by a singly unsorted linked list of messages), write a function that
remove duplicated messages from it.

## Solution
``` kotlin
class EmailNode (
    var email : String,
    var next : EmailNode? = null
) 

class EmailLinkedList {
    
    private var first : EmailNode? = null
    private var hash = mutableMapOf<String, Boolean>()
    
    fun insert(node: EmailNode) {
        node.next = first
        first = node  
    }
    
    fun removeDuplicate() { 
        var newFirst : EmailNode? = null 
        var current = first  
        while(current != null) {  
            if (hash.getOrElse(current.email){true}) {
                var currentNewHead = EmailNode(current.email)
             	currentNewHead.next = newFirst
             	newFirst = currentNewHead  
            	hash.put(current.email, false)
            }
        	current = current.next  
        }  
        first = newFirst  
    }

    fun print() {
        var current = first
        print ("List: ")
        while(current != null) { 
            print("${current.email} ")
            current = current.next
        }
        println()
    }    
    
}

fun main() {
    
    var lista = EmailLinkedList()
    lista.insert(EmailNode("email1")) 
    lista.insert(EmailNode("email5")) 
    lista.insert(EmailNode("email2")) 
    lista.insert(EmailNode("email5")) 
    lista.insert(EmailNode("email3"))
    lista.insert(EmailNode("email5"))  
    lista.insert(EmailNode("email4")) 
    lista.insert(EmailNode("email5")) 
    lista.insert(EmailNode("email5")) 
    lista.insert(EmailNode("email5"))   
 
    lista.print()
    
    lista.removeDuplicate()
     
    lista.print()
    
}
```

## Output
```
List: email5 email5 email5 email4 email5 email3 email5 email2 email5 email1 
List: email1 email2 email3 email4 email5 
```

## Run online
```
https://pl.kotl.in/R9Oy7ZXOZ
```

## Explain
```
The proposed solution has complexity O(n) due it's checked each item of a given list with N elements.
```
