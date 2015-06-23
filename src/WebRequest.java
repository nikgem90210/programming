//@PostConstruct
//public void setJMSMessageListener() {
//	MessageListener ml = new MessageListener() {
//
//		@Override
//		public void onMessage(Message paramMessage) {
//			try {
//				Object message = ((ObjectMessage) paramMessage).getObject();
//				logger.info("SE callback consumer recieved message : " + message);
//				String messageStr = message.toString();
//				CPNotificationDTO notification = gson.fromJson(messageStr, CPNotificationDTO.class);
//				processNotification(notification);
//			}
//			catch (JMSException e) {
//				e.printStackTrace();
//			}
//		}
//
//	};
//	cpNotificationConsumerJMSManager.setMessageListener(ml);
//}