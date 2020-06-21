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