public class TrainBarriers {

    private PassengerRepository repository;
    private EmailService emailService;

    public TrainBarriers(PassengerRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    public void passengerEntry(int passengerId) throws Exception {
        if (!passengerIsEligible(passengerId)) {
            throw new Exception();
        }
        repository.registerPassengerOnTrain(passengerId);
        emailService.notifyPassenger(passengerId);
    }

    public boolean passengerIsEligible(int passengerId) {
        return true;
    }
}
