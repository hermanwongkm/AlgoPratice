# Given the head of a linked list, remove the nth node from the end of the list and return its head.


# Example 1:

# Input: head = [1,2,3,4,5], n = 2
# Output: [1,2,3,5]

# Example 2:

# Input: head = [1], n = 1
# Output: []

# Example 3:

# Input: head = [1,2], n = 1
# Output: [1]


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        slowPointer = head
        fastPointer = head
        for i in range(n):
            fastPointer = fastPointer.next

        # we need to end early because it will fail the base of a single array
        # For example, head = [1], n = 1
        # Then fastPointer will become null
        if fastPointer == None:
            return head.next

        while fastPointer.next:
            fastPointer = fastPointer.next
            slowPointer = slowPointer.next
        print(fastPointer)
        # You assign it to the next.next instead of fastPointer because [1,2] would fail
        # Because it will stop if the fastPointer.next is null
        slowPointer.next = slowPointer.next.next
        return head
