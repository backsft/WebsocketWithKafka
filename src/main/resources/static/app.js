let stompClient;

function connect() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnect, onError);
}

function onConnect() {
    stompClient.subscribe('/topic/chat', onMessageReceived);
}

function onMessageReceived(payload) {
    const message = payload.body;
    displayMessage(message);
}

function displayMessage(message) {
    const chatMessages = document.getElementById('chat-messages');
    const messageElement = document.createElement('div');
    messageElement.textContent = message;
    chatMessages.appendChild(messageElement);
}

function onError(error) {
    console.error('WebSocket Error:', error);
}

function sendMessage() {
    const messageInput = document.getElementById('message-input');
    const message = messageInput.value.trim();

    if (message !== '') {
        stompClient.send('/app/send/message', {}, message);
        messageInput.value = '';
    }
}

connect();
