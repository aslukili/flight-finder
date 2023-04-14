export interface Reservation {
    id: number;
    flight: {
        id: number,
        airline: {
            id: number,
            name: string,
            country: {
                id: string,
                name: string
            }
        },
        number: string,
        aircraft: {
            id: number,
            name: string
        },
        departureAirport: {
            id: string,
            name: string,
            city: {
                id: number,
                name: string,
                country: {
                    id: string,
                    name: string
                },
                timezone: string,
                summerShift: boolean
            }
        },
        arrivalAirport: {
            id: string,
            name: string,
            city: {
                id: number,
                name: string,
                country: {
                    id: string,
                    name: string
                },
                timezone: string,
                summerShift: boolean
            }
        }
    };
    user: {
        id: number;
        fullName: string;
        username: string;
        password: string;
        email: string;
        phone: string;
        role: string;
        enabled: boolean;
        authorities: [
            {
                authority: string
            }
        ];
        accountNonLocked: boolean;
        accountNonExpired: boolean;
        credentialsNonExpired: boolean
    };
}